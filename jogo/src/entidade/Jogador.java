package entidade;

public class Jogador {
    private String id;
    private int pos;

    public Jogador(String id){
        this.id = id;
        this.pos = 0;
    }

    public String getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
