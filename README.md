# picpay-challenge
Desafio Backend do PicPay com Java e Spring Boot

Iniciando o projeto java (JPA, MySql, Validator, OpenFeign) [OK]
Configurando MySQL no Docker [ok]

## Configuração do Docker no WSL https://www.youtube.com/watch?v=Lgh8JgcYFwM
Configurando Comunicação do MySql no SpringBoot[ok]

## Funcionalidade de Cadastro de Wallet (Carteira) ##

# Mapear as entidades (Wallet, WalletType) [ok]
# Criar inicialização de WalletType no banco de dados [ok]
Criar a funcionalidade de cadastro de Wallet [ok]
	# 1 validação dos dados únicos [ok]
	# 2 inserção na base [ok]
# Criar tratamento de exceções com ProblemDetails e RestExceptionHandler [ok]
# Criar validação dos dados de entrada [ok]
# Ajustar tratamento de excessões [ok]

---

# Funcionalidade de Transferêcia:

Mapear a entidade (Transaction) [ok]
Criar os mocks do Autorizador e Notificador Externo (https://designer.mocky.io/) [ok]
Criar o serviço que irá consultar o autorizador externo [ok]
Criar o serviço que irá notificar o recebimento da transferência [ok]
Criar a funcionalidade de transação:
	1 - Validade o tipo da carteira [ok]
	2 - Validar o saldo [ok]
	3 - Consultar o autorizador externo [ok]
	4 - Realizar a transferência [ok]
	5 - Enviar notificação para o recebedor (CompletableFututre) [ok]
Validar o tratamento de exceções com RestExceptionHandler  [ok]
Testar a API e validar no banco de dados [ok]

---

# Ajuste final

Aplicar loggin no projeto com o SLF4J[ok]

--- 
# Melhorias:

implementar Extrato, Deposito e Saque [Pendente]