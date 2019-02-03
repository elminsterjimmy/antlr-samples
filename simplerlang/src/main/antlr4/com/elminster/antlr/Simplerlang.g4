grammar Simplerlang ;
fragment DIGIT : [0-9] ;
fragment CHAR : [a-z] ;

program
	: statement+ ;

statement
	: let
	| show ;

let
	: VAR '=' INT ;

show
	: 'show' (INT | VAR) ;

print
	: 'print' (INT | VAR) ;

VAR
	: CHAR+ ;

INT
	: DIGIT+ ;

WS
	: [ \r\n\t]+ -> skip ;

