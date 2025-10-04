package aula2;
public class Carro{
    String marca;
    String modelo;
    int ano;
    private void exibirInfo(){
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
    }
    public static void main(String[] args) {
        Carro meuCarro1 = new Carro();
        Carro meuCarro2 = new Carro();
        meuCarro1.marca = "Toyota";
        meuCarro1.modelo = "Corolla";
        meuCarro1.ano = 2020;
        meuCarro1.exibirInfo();
        meuCarro2.marca = "Honda";
        meuCarro2.modelo = "Civic";
        meuCarro2.ano = 2019;
        meuCarro2.exibirInfo();
    }
}