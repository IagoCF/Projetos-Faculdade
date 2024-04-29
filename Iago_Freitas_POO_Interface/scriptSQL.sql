create database atividade10;
use atividade10;

create table livro(
	idLivro varchar(10) primary key,
    nome varchar(30) not null,
    autor varchar(30) not null,
    anoPubli date,
    tipo varchar(30) not null
);

create table categoria(
	idCategoria varchar(10) primary key,
    nome varchar(30) not null
);

create table pertence(
	id int primary key auto_increment,
    idLivro varchar(10) not null,
    foreign key (idLivro) references livro(idLivro),
	idCategoria varchar(10) not null,
    foreign key (idCategoria) references categoria(idCategoria)
);

select * from livro;
select * from categoria;
select * from pertence;
delete from livro;
delete from categoria;