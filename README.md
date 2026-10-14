# Sistema de Hotel

Sistema de terminal em Java para controlar reservas, check-in e check-out de um hotel.
Projeto 1 da disciplina de Linguagem de Programação (Java).

## Integrantes

- Ana Clara Souza Barbosa
- Atamara Batista Tavares
- Gabriela Goncalves de Souza

## Descrição do problema

Um hotel pequeno controla as reservas à mão e acaba tendo erros, como dois hóspedes no mesmo quarto,
check-out sem check-in e valor da estadia calculado errado. Este sistema organiza esse controle
pelo terminal e impede essas operações inválidas.

## Funcionalidades

O sistema tem um menu principal com as opções:

1. **Fazer reserva:** cadastra nome, CPF, número do quarto e quantidade de dias.
2. **Consultar reserva:** mostra os dados da reserva pelo CPF.
3. **Check-in:** registra a entrada do hóspede.
4. **Check-out:** registra a saída, libera o quarto e mostra o valor da estadia.
5. **Ver quartos:** lista os quartos e mostra se estão disponíveis ou ocupados.
6. **Sair:** encerra o programa.

Quartos cadastrados:

| Quarto | Tipo | Diária |
|---|---|---|
| 101 | Solteiro | R$ 120 |
| 102 | Solteiro | R$ 120 |
| 201 | Casal | R$ 180 |
| 202 | Casal | R$ 180 |
| 301 | Suíte | R$ 250 |

### Regras de negócio

- Não é possível reservar um quarto que não existe ou que já está ocupado.
- O nome não pode ficar vazio, o CPF precisa ter 11 números e os dias devem ser pelo menos 1.
- O check-in só pode ser feito uma vez.
- O check-out só pode ser feito depois do check-in e libera o quarto.
- Se o usuário digitar uma letra onde deveria ser um número, o sistema pede de novo.

## Estrutura do projeto

O código fica em `projeto/src/sistema`.

| Classe | Função |
|---|---|
| `Quarto` | número, tipo, valor da diária e disponibilidade; reservar, liberar e calcular a estadia |
| `Hospede` | nome, CPF, quarto e dias; check-in, check-out e valor total |
| `Hotel` | guarda as listas (`ArrayList`) de quartos e hóspedes e aplica as regras da reserva |
| `Menu` | menu principal e leitura de dados com `Scanner` |

## Como executar

**No NetBeans:** abra o projeto e clique em *Run* (F6). A classe principal é `sistema.Menu`.

**Pelo terminal**, a partir da pasta `projeto/src`:

```
javac sistema/*.java
java sistema.Menu
```

## Exemplo de utilização

```
===== HOTEL =====
1 - Fazer reserva
2 - Consultar reserva
3 - Check-in
4 - Check-out
5 - Ver quartos
6 - Sair
Escolha uma opção: 1

Nome do hóspede: Maria Silva
CPF (11 números): 123.456.789-09
Número do quarto: 201
Quantidade de dias: 3

Reserva realizada!
Hóspede: Maria Silva
CPF: 12345678909
Quarto: 201 (Casal)
Dias: 3
Valor total: R$ 540,00
Situação: Aguardando check-in
```

## Divisão de responsabilidades

| Integrante | Responsabilidade |
|---|---|
| Ana Clara Souza Barbosa | `Quarto.java` |
| Gabriela Gonçalves de Souza | `Hotel.java` |
| Atamara Batista Tavares | `Hospede.java` e `Menu.java` |

