[![Build Status](https://travis-ci.org/thaua97/AjudaAE-api.svg?branch=master)](https://travis-ci.org/thaua97/AjudaAE-api)

# AjudaAE - API
Projeto da disciplina de Algoritimos 3 que consiste em, um sistema de abertura e visualização de chamados tecnicos, para empressas 
do ramo de assistencia tecnica em Hardwares e softwares.

## Módulos
* DevTools
* Web
* JPA
* MySQL
* Flyway
* Security
* Json Web Token

## Branchs
* <code>Master  </code>

    <small> Branch padrão da aplicação, onde o codigo fonte presente nela, sera o mesmo no ambiente de produção.</small>
    


* <code>Develop</code>

    <small>Branch onde a aplicação sera desenvolvida e testada.</small>

* <code>Auth</code>

    <small>Branch responsavel pelo desenvolvimento e testes da autenticação.</small>


## Rotas
As rotas estão seguindo a especificação rest, realizando as operções básicas para um CRUD:

### Clientes

* /clientes <code>GET</code>
* /clientes <code>POST</code>
* /clientes/{id} <code>GET</code>
* /clientes/{id} <code>PUT</code>
* /clientes/{id} <code>DELETE</code>

### Chamados

* /chamado <code>GET</code>
* /chamado <code>POST</code>
* /chamado/{id} <code>PUT</code>
* /chamado/{id} <code>GET</code>
* /chamado/{id} <code>DELETE</code>

### Funcionarios


* /funcionarios <code>GET</code>
* /funcionarios <code>POST</code>
* /funcionarios/{id} <code>PUT</code>
* /funcionarios/{id} <code>GET</code>
* /funcionarios/{id} <code>DELETE</code>
