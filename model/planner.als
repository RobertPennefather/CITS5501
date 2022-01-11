// A time type, additional parameters for minute and hour are omitted 
// as they are not relevant to the model
sig Time{}

// A route object consisting of an ordered list of one or more travel stops
// with an optional leave and arrive time
sig Route{ 
	start: one TravelStop, 
 	end: one TravelStop,
	leaveTime: lone Time,
	arriveTime: lone Time
}

// A travel stop object can have one or none, following and previous stops
sig TravelStop {
	previous: lone TravelStop,
	following: lone TravelStop, 
}

// A route cannot have both a leave and an arrive time
fact oneTime{ all r: Route, leave: r.leaveTime, arrive: r.arriveTime | leave != arrive and #(leave+arrive) <= 1}

// The next travel stop is the previous of the last
fact linkedList{ all t: TravelStop, following : t.following | following.previous = t }

// There is only one start and end travel stop
one sig StartTravelStop extends TravelStop { } { no previous }
one sig EndTravelStop extends TravelStop { } { no following }

// All travel stops are connected to the start and end
fact oneStart{ TravelStop in StartTravelStop.*following }
fact oneEnd{ TravelStop in EndTravelStop.*previous }

// ASSERTION:
// A route from starting stop A to ending stop B has 
// exactly the same number of items in it as the reverse trip
assert sameStopsRoute{ 
	all r: Route, s: r.start, e: r.end  | 
	all r2: Route, s2: r2.start, e2: r2.end  | 
	(s = e2 and s2 = e) =>	// All routes which are the same in reverse
	#(s.*following-e.*following) = #(s2.*previous-e2.*previous) and 
	#(s.*previous-e.*previous) = #(s2.*following-e2.*following)
	// Confirming the count is the same going forwards and backwards
}
check sameStopsRoute for 6

// ASSERTION:
// A route from any stop to itself consists of only one stop
assert oneStopRoute{ 
	all r: Route, s: r.start, e: r.end | 
	s=e => 	// All routes where the start and the end are the same
	#(s.*following-e.^following) = 1 and 
	#(s.*previous-e.^previous) = 1
	// Confirming that only one stop exists forwards and backwards
}
check oneStopRoute for 6

