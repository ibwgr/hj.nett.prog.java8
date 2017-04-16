Aufgabe 1a)

CREATE TABLE bewertung(
	id serial PRIMARY KEY,
	sterne integer NOT NULL
);

CREATE TABLE person(
	id serial PRIMARY KEY,
	login VARCHAR NOT NULL,
	passwort VARCHAR NOT NULL,
	name VARCHAR
);

CREATE TABLE rezept(
	id serial PRIMARY KEY,
	name VARCHAR NOT NULL,
	anleitung VARCHAR NOT NULL
);

CREATE TABLE zutat(
	id serial PRIMARY KEY,
	menge integer,
	masseinheit VARCHAR,
	zutat VARCHAR NOT NULL
)

Aufgabe 1b)

ALTER TABLE rezept ADD FOREIGNKEY (person_id) REFERENCES person(id);
ALTER TABLE bewertung ADD FOREIGNKEY (person_id) REFERENCES person(id);
ALTER TABLE bewertung ADD FOREIGNKEY (rezept_id) REFERENCES rezept(id);
ALTER TABLE zutat ADD FOREIGNKEY (rezept_id) REFERENCES rezept(id);

Aufgabe 2a)

SELECT COUNT(*) FROM bestellung

Aufgabe 2b)

SELECT * FROM bestellung
WHERE benutzername = 'mmueller'

Aufgabe 2c)

SELECT * FROM kunde
ORDER BY vorname, nachname

Aufgabe 3a)

SELECT * FROM bestellung b
JOIN kunde  k ON (b.benutzername=k.benutzername)
WHERE k.nachname = 'Müller'

Aufgabe 3b)

SELECT COUNT(*) FROM pizza p
JOIN bestellposition bp ON(p.name=bp.pizza)
WHERE bp.bestellnr = 2

Aufgabe 3c)

