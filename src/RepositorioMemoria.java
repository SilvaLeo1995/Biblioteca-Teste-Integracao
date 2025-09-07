import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.HashSet;
import java.util.stream.Collectors;

public class RepositorioMemoria implements Repositorio{

    private Map<String, Livro> acervo;
    private Map<Livro, Usuario> emprestimos;

    public RepositorioMemoria (){
        acervo = new HashMap<String,Livro>();
        emprestimos = new HashMap<Livro, Usuario>();
    }

    public void adicionarLivroAcervo (String isbn, Livro livro) {
        acervo.put(livro.getISBN(), livro);
    }

    public boolean livroEstaEmprestado (Livro livro) {
        return emprestimos.containsKey(livro);
    }

    public void emprestarLivro (Livro livro, Usuario usuario) {
        emprestimos.put(livro, usuario);
    }

    public void receberLivroEmprestado (Livro livro) {
        emprestimos.remove(livro);
    }

    public List<Livro> livrosEmprestadosUsuario (Usuario usuario) {
        return emprestimos.entrySet().stream()
                .filter(e -> e.getValue() == usuario)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
