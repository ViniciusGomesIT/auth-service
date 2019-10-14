# auth-service

Para executar este serviço, basta executar como uma aplicação spring boot, o projeto roda por padrão na porta 9091 e o endpoint de obtenção do token é http://localhost:9091/oauth/token.
Para acessar endpoint o login é necessário criar uma requisição do tipo form-data com a seguinte autentição de client:
username: userApi
password: 123456;

Também é necessário configurar o usuário para login:
username: admin123
password: 12345678
grant_type: password
