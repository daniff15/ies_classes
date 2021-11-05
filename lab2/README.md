# IES_98498

# Review Questions
## A
Caso o utilizador queira ler a página web baseado no seu input, a ideia básica do servlet container é usar java para gerar dinamicamente a página web do lado do server.
Sendo assim, o servlet container é essencialmente uma parte do servidor web que interage com os servlets.

É responsável por:

    -> gerir o ciclo de vida de servlets

    -> carregar os servlets para memória

    -> inicializar e invocar os metodos dos servlets

    -> destruir os servlets

## B
O spring boot usa o padrão MVC no qual a app é dividida em 3 componentes: 
Spring Boot uses the MVC pattern in which the application is divided in 3 components:
Depois de um pedido HTTP ter sido feito, o Controller recebe e processa esse pedido. O Model está representado nos dados da aplicação e o View nos ficheiros HTML.

## C
As starters dependencies fazem com que seja possível correr a Spring Boot app sem adicionar outras dependencias adicionais, pois já garante todas as dependências default que necessita. 

## D
@EnableAutoConfiguration - enable Spring Boot's auto-configuration mechanism so that the project is ready to be built.
@ComponentScan - It allows the Spring Boot to identify all Spring annotations.
@Configuration - It allows to add aditional configurations to our Spring project.

## E
-   Use nouns instead of verbs in endpoint paths

-   Use logical nesting on endpoints

-   Handle errors gracefully and return standard error codes

-   Maintain good security practices

-   Cache data to improve performance
