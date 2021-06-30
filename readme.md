# Trabalhando com banco de dados utilizando JDBC e JPA

## Configurando banco de dados

Scripts SQL para criação do banco de dados no MySQL:

```sql
CREATE DATABASE digital_innovation_one;

USE digital_innovation_one;

CREATE TABLE aluno(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(80) NOT NULL,
    idade INTEGER NOT NULL,
    estado CHARACTER(2) NOT NULL
);
```

Saída na linha de comando do MySQL:
``` sh
mysql>
mysql> CREATE DATABASE digital_innovation_one;
Query OK, 1 row affected (0.09 sec)
mysql>
mysql> USE digital_innovation_one;
Database changed
mysql>
mysql> CREATE TABLE aluno(
    ->     id INTEGER PRIMARY KEY AUTO_INCREMENT,
    ->     nome VARCHAR(80) NOT NULL,
    ->     idade INTEGER NOT NULL,
    ->     estado CHARACTER(2) NOT NULL
    -> );
Query OK, 0 rows affected (0.68 sec)
mysql>
```

