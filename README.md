# picpay-challenge
## Desafio Backend do PicPay com Java e Spring Boot

Iniciando o projeto java (JPA, MySql, Validator, OpenFeign)
Configurando MySQL no Docker
Configuração do Docker no WSL https://www.youtube.com/watch?v=Lgh8JgcYFwM

Configurando Comunicação do MySql no SpringBoot
Funcionalidade de Cadastro de Wallet (Carteira) 

Mapear as entidades (Wallet, WalletType) 
Criar inicialização de WalletType no banco de dados
Criar a funcionalidade de cadastro de Wallet
	# 1 validação dos dados únicos
	# 2 inserção na base
Criar tratamento de exceções com ProblemDetails e RestExceptionHandler
Criar validação dos dados de entrada
Ajustar tratamento de excessões

# Funcionalidade de Transferêcia:

Mapear a entidade (Transaction) 
Criar os mocks do Autorizador e Notificador Externo (https://designer.mocky.io/) 
Criar o serviço que irá consultar o autorizador externo 
Criar o serviço que irá notificar o recebimento da transferência 
Criar a funcionalidade de transação:
	1 - Validade o tipo da carteira 
	2 - Validar o saldo 
	3 - Consultar o autorizador externo 
	4 - Realizar a transferência 
	5 - Enviar notificação para o recebedor (CompletableFututre) 
Validar o tratamento de exceções com RestExceptionHandler  
Testar a API e validar no banco de dados 

# Ajuste final
Aplicar logger no projeto com o SLF4J.
 
# Melhorias:
Implementar Extrato, Deposito e Saque [Pendente]

NOTA: esse código foi compartilhado por Build&Run e reproduzido por mim.  
