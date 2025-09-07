import java.util.List;

public interface Repositorio {

    public void adicionarLivroAcervo (String isbn, Livro livro);
    public boolean livroEstaEmprestado (Livro livro);
    public void emprestarLivro (Livro livro, Usuario usuario);
    public void receberLivroEmprestado (Livro livro);
    public List<Livro> livrosEmprestadosUsuario (Usuario usuario);
}
