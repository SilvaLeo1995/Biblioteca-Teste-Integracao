import java.util.List;

public class Biblioteca {

    private Repositorio repo;

    public Biblioteca(Repositorio repo) {
        this.repo = repo;
    }

    public void adicionarLivroAcervo(Livro livro) {
        repo.adicionarLivroAcervo(livro.getISBN(), livro);
    }

    public void emprestarLivro(Livro livro, Usuario usuario) throws ExcecaoLivroEmprestado {
        if (repo.livroEstaEmprestado(livro)) {
            throw new ExcecaoLivroEmprestado();
        }
        repo.emprestarLivro(livro, usuario);
    }

    public void receberLivroEmprestado(Livro livro) {
        repo.receberLivroEmprestado(livro);
    }

    public List<Livro> livrosEmprestadosUsuario(Usuario usuario) {
        return repo.livrosEmprestadosUsuario(usuario);
    }
}
