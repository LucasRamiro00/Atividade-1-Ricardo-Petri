public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = new No(null);
        System.out.println("Árvore Binária criada com sucesso!");
    }

//    public void inserir(Integer conteudo) {
//        No novoNo = new No(conteudo);
//
//        if(estaVazia()) {
//            this.raiz = novoNo;
//        } else {
//            No aux = this.raiz;
//            while(true) {
//                if (aux.getConteudo() > novoNo.getConteudo()) {
//                    if (aux.getEsquerda() == null) {
//                        aux.setEsquerda(novoNo);
//                        return;
//                    } else {
//                        aux = aux.getEsquerda();
//                    }
//                } else if (aux.getConteudo() == novoNo.getConteudo()) {
//                    System.out.println("Não é possível informar nós repetidos.");
//                    return;
//                } else {
//                    if (aux.getDireita() == null) {
//                        aux.setDireita(novoNo);
//                        return;
//                    } else {
//                        aux = aux.getDireita();
//                    }
//                }
//            }
//        }
//    }

    public void inserir(Integer conteudo) {
        No novoNo = new No(conteudo);

        if(estaVazia()) {
            this.raiz = novoNo;
        } else {
            inserirRecursivo(novoNo, this.raiz);
        }
    }

    public void inserirRecursivo(No novoNo, No atual) {
        if (atual.getConteudo() > novoNo.getConteudo()) {
            if (atual.getEsquerda() == null) {
                atual.setEsquerda(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getEsquerda());
            }
        } else if (atual.getConteudo() == novoNo.getConteudo()) {
            System.out.println("Não é possível informar nós repetidos.");
            return;
        } else {
            if (atual.getDireita() == null) {
                atual.setDireita(novoNo);
                System.out.println("O nó " + novoNo.getConteudo() + " foi inserido na Árvore.");
                return;
            } else {
                inserirRecursivo(novoNo, atual.getDireita());
            }
        }
    }

    public boolean estaVazia() {
        if(this.raiz == null || this.raiz.getConteudo() == null) {
            return true;
        } else {
            return false;
        }
    }

    private void preOrdem(No no) {
        if(no == null || no.getConteudo() == null) {
            return;
        }
        System.out.println(no.getConteudo());
        preOrdem(no.getEsquerda());
        preOrdem(no.getDireita());
    }

    private void emOrdem(No no) {
        if(no == null || no.getConteudo() == null) {
            return;
        }
        emOrdem(no.getEsquerda());
        System.out.println(no.getConteudo());
        emOrdem(no.getDireita());
    }

    private void posOrdem(No no) {
        if(no == null || no.getConteudo() == null) {
            return;
        }
        posOrdem(no.getEsquerda());
        posOrdem(no.getDireita());
        System.out.println(no.getConteudo());
    }

    public void exibir(String percurso) {
        switch (percurso){
            case "Pre":
            case "pre":
                preOrdem(this.raiz);
                break;
            case "Em":
            case "em":
                emOrdem(this.raiz);
                break;
            case "Pos":
            case "pos":
                posOrdem(this.raiz);
                break;
        }
    }

    public void remover(Integer valor)
    {
        if (estaVazia())
        {
            return;
        }

        this.raiz = removerNo(this.raiz, valor);

        if (this.raiz == null)
        {
            this.raiz = new No(null);
        }
    }

    private No removerNo(No aux, Integer valor)
    {
        if (aux == null || aux.getConteudo() == null)
        {
            return null;
        }

        if (valor < aux.getConteudo())
        {
            aux.setEsquerda(removerNo(aux.getEsquerda(), valor));
        }
        else if (valor > aux.getConteudo())
        {
            aux.setDireita(removerNo(aux.getDireita(), valor));
        }
        else
        {
            if (aux.getEsquerda() == null)
            {
                return aux.getDireita();
            }
            else if (aux.getDireita() == null)
            {
                return aux.getEsquerda();
            }

            No min = aux.getDireita();
            while (min.getEsquerda() != null)
            {
                min = min.getEsquerda();
            }

            aux.setConteudo(min.getConteudo());
            aux.setDireita(removerNo(aux.getDireita(), min.getConteudo()));
        }

        return aux;
    }
}