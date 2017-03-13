s_v(i, 1). s_v(v, 5). s_v(x, 10). 
s_v(l, 50). s_v(c, 100). s_v(d, 500).
s_v(m, 1000).

gte(S1, S2) :-
	s_v(S1, V1), s_v(S2, V2),
	not(V1 < V2).

validate(Symbol) :-
	repeat(Symbol), write('repeat validation pass...'), nl,
	sub_constrain(Symbol), write('sub constraint validation pass...'), nl.

repeat([]) :- !.
repeat([_]) :- !.
repeat([_,_]) :- !.
repeat([H,H,H|R]) :- member(H, [i,x,c,m]), not(member(H, R)), repeat(R), !.
repeat([H,H,H,H|_]) :- fail.
repeat([H,H,H,Other,H|R]) :- member(H, [i,x,c,m]), not(member(H,R)), gte(H,Other), repeat(R), !.

sub_constraint([]) :- !.
sub_constraint([_]) :- !.
sub_constraint([F,S|R]) :- gte(F,S), sub_constraint([S|R]).
sub_constraint([i,S|R]) :- member(S, [v,x]), sub_constraint([S|R]).
sub_constraint([x,S|R]) :- member(S, [l,c]), sub_constraint([S|R]).
sub_constraint([c,S|R]) :- member(S, [d,m]), sub_constraint([S|R]).
