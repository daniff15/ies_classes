# PERGUNTAS ALINEA B

## The “UserController” class gets an instance of “userRepository” through its constructor; how is this new repository instantiated? 

private final UserRepository userRepository;

@Autowired
public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
}

A notação @Autowired fornece um melhor controlo sobre onde e como o autowiring deve ser conseguido. 
Quando o Spring encontra a notação @Autowired usada setter methods, tenta realiza byType autowiring nesse método.

## List the methods invoked in the “userRepository” object by the “UserController”. Where are these methods defined?

The method invoked in userRepository is findByName(String name). This method is defined at CrudRepository.
We create a query using the JPA criteria API from this.

## Where is the databeing saved?

Os dados estão a ser guardados com o H2 database, ou seja, estão a ser guardados em memória, o que significa que não é persistente.

## Where is the rule for the “not empty” email address defined?

A notação @NotBlank usa a classe NotBlankValidator, que verifica se o length da sequência de caracteres passada(trimmed) não é vazia. 