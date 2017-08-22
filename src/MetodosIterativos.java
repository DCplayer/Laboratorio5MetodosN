import java.util.ArrayList;

/**
 * Created by Diego Castaneda on 21/08/2017.
 */
public class MetodosIterativos {
    private ArrayList<Integer> coeficientes = new ArrayList<>();
    private ArrayList<Integer> incognitas = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> matriz = new ArrayList<>();


    public MetodosIterativos(ArrayList<ArrayList<Integer>> M){
        this.matriz = M;
    }

    public ArrayList<Integer> GaussSiedel(){
        /*Me falto un While algo grande para que se repita hasta que la tolerancia ya no ceda o hasta el numero de
        * iteraciones especificadas*/

        for(ArrayList<Integer> fila: matriz){
            /*Falto inicializar las variables en cierto valor especifico*/

            /*Obteniendo los coeficientes de la fila en la que se está*/
            coeficientes.clear();
            coeficientes.addAll(fila);
            coeficientes.remove(coeficientes.size()-1);

            /*Determinando ciertos valores especificos de cada linea para definir el valor aproximado de la variable*/
            int bi = fila.get(fila.size() - 1);
            int pos = matriz.indexOf(fila);

            int index = 0;
            int Xi = bi;
            while(index < coeficientes.size()){
                if(index != pos){
                    int AiXi = coeficientes.get(index) * incognitas.get(index);
                    Xi = Xi - AiXi;
                }
                index = index +1;
            }
            Xi = Xi / incognitas.get(pos);
            incognitas.set(pos, Xi);
        }
        return incognitas;
    }


}
