package Modelo;

public class Participante {

    private String Usuario;
    private int chances;

    //Constructores
    public Participante() {
    }

    public Participante(String Usuario, int chances) {
        this.Usuario = Usuario;
        this.chances = chances;
    }

    // Métodos getters y setters
    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public int getChancesExtra() {
        return chances;
    }

    public void setChancesExtra(int chances) {
        this.chances = chances;
    }

    public int getChances() {
        return chances;
    }

    public void setChances(int chances) {
        this.chances = chances;
    }

    //Metodo toString
    @Override
    public String toString() {
        return "Participante{" + "Usuario=" + Usuario + ", chances=" + chances + '}';
    }
    
 
}
