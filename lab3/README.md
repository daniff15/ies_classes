# IES - 98498
# Review Questions

# A

A diferença entre @RestController e @Controller é apenas que o primeiro trata-se de uma combinação de @Controller e @ResponseBody, tornando o desenvolvimento ligeiramente mais fácil

# B

Diagrama na pasta lab303

Quote and Movie:
Representa a quote e o filme, respetivamente
Tem contrutor, getters e setters
@Id e @GeneratedValue permite auto-gerar e incrementar o id

ErrorDetails:
Tem os detalhes para o caso de dar erro

GlobalExceptionHandler:
Permite verificar qual é o tipo de erro encontrado

ResourceNotFoundException:
Retorna mensagem em caso de erro

MovieRepository:
Possui um repositório com os filmes

MovieController:
Faz o handle do pedido HTTP e retorna o resultado

QuoteProdute:
Tem o serviço para podermos acessar ao que é pedido no HTTP request

# C

@Table: Especifica a tabela na base de dados que vai guardar a entidade, neste caso está a definir-se que as entidades Employee vão ser guardadas na tabela "employees" na BD MySQL.
@Column: Serve para mapear um atributo como uma coluna na tabela da base de dados.
@Id: Identifica um atributo como Primary Key da tabela da base de dados


# D

No nosso caso usamos o @Autowired na property employeeRepository isto serve para evitar fazer metodos setter.

private final UserRepository userRepository;

@Autowired
public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
}

A notação @Autowired fornece um melhor controlo sobre onde e como o autowiring deve ser conseguido. 
Quando o Spring encontra a notação @Autowired tenta realizar byType autowiring nesses métodos.