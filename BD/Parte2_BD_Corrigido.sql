-- Criação das tabelas

create schema biblioteca;
use biblioteca;

create table biblioteca(
CodBib integer not null,
NomeBib varchar(30),
primary key(CodBib));

create table obra(
CodObra integer not null,
TituloObra varchar(30),
AnoObra integer,
EditoraObra varchar(30),
CodBib integer,
primary key(CodObra),
foreign key(CodBib) references biblioteca(CodBib) on delete cascade on update cascade);

create table usuario(
CodUsu integer not null,
NomeUsu varchar(30),
primary key(CodUsu));

create table emprestimo(
CodObra integer not null,
CodUsu integer not null,
primary key(CodObra, CodUsu),
foreign key(CodObra) references obra(CodObra) on delete cascade on update cascade,
foreign key(CodUsu) references usuario(CodUsu) on delete cascade on update cascade);

create table reserva(
CodObra integer not null,
CodUsu integer not null,
DataVencimento date not null,
primary key(CodObra, CodUsu, DataVencimento),
constraint foreign key(CodObra) references obra(CodObra) on delete cascade on update cascade,
constraint foreign key(CodUsu) references usuario(CodUsu) on delete cascade on update cascade);


-- Visões
create view emprestimos
as select u.NomeUsu, o.TituloObra
from usuario as u, emprestimo as e, obra as o
where e.CodUsu=u.CodUsu and e.CodObra=o.CodObra;

create view usuarios_com_reserva
as select u.NomeUsu
from usuario as u
where u.CodUsu in (select CodUsu from reserva);


-- Inserções no BD

insert into biblioteca(CodBib, NomeBib) values
(001, 'Biblioteca A'),
(002, 'Biblioteca B'),
(003, 'Biblioteca C'),
(004, 'Biblioteca D');

insert into usuario(CodUsu, NomeUsu) values
(001, 'Edvan'),
(002, 'Jorge'),
(003, 'Breno'),
(004, 'João');

insert into obra(CodObra, TituloObra, AnoObra, EditoraObra, CodBib) values
(001, 'Livro 01', 1990, 'Editora Abril', 001),
(002, 'Livro 02', 2000, 'Editora Saraiva', 002),
(003, 'Livro 03', 1998, 'Editora Brasil', 001),
(004, 'Livro 04', 2007, 'Editora Saraiva', 003);

insert into emprestimo(CodObra, CodUsu) values
(001, 001),
(002, 002),
(003, 001);

insert into reserva(CodObra, CodUsu, DataVencimento) values
(001, 002, '20/07/2015'),
(002, 001, '30/07/2015');







