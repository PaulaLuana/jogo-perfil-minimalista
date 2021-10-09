package organizacao_interface;

import java.util.ArrayList;

public interface ICarta {
    public String getResposta();
    public String getTipo();
    public int getNumDicas();
    public ArrayList<IDica> getDicasUsuais();
    public ArrayList<IDica> getDicasUsadas();
}
