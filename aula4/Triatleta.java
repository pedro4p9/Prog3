package aula4;

public interface Triatleta {
    public interface Corredor {
        void correr();
    }
    public interface Ciclista {
        void pedalar();
    }
    public interface Nadador {
        void nadar();
    }
    public class Atleta implements Corredor, Ciclista, Nadador {
        @Override
        public void correr() {
            System.out.println("O atleta está correndo.");
        }
        @Override
        public void pedalar() {
            System.out.println("O atleta está pedalando.");
        }
        @Override
        public void nadar() {
            System.out.println("O atleta está nadando.");
        }
    }
    public static void main(String[] args) {
        Atleta atleta = new Atleta();
        atleta.correr();
        atleta.pedalar();
        atleta.nadar();
    }
}
