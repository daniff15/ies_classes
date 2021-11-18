# PERGUNTAS ALINEA B

## The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated? 

A classe UserRepository é inicializada porque o UserController tem a notação @Autowired, que injeta uma instância do UserRepository no objeto do UserController

## List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

Os métodos chamados são findAll(), save(), findById() and delete(). Estes são definidos na classe CrudRepository

## Where is the databeing saved?

Os dados estão a ser guardados com o H2 database, ou seja, estão a ser guardados em memória, o que significa que não é persistente.

## Where is the rule for the “not empty” email address defined?

A regra "not empty" é definida na classe User, com a notação @NotBlank quando declaramos o atributo

README DAS PERGUNTAS FINAIS
private final UserRepository userRepository;

@Autowired
public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
}

A notação @Autowired fornece um melhor controlo sobre onde e como o autowiring deve ser conseguido. 
Quando o Spring encontra a notação @Autowired usada setter methods, tenta realiza byType autowiring nesse método.
