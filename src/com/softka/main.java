import java.util.function.BiFunction;
import java.util.stream.IntStream;

class main {
    public static void main(String[] args) {

        //Creamos la funcion de suma
        BiFunction<Integer, Integer, Integer> sumar = (a,b) -> a+b;
        //Creamos la funcion de resta
        BiFunction<Integer, Integer, Integer> restar = (a,b) -> a-b;
        //Creamos la funcion de multiplicacion
        BiFunction<Integer, Integer, Integer> multiplicar = (a,b) ->
                IntStream.range(0,a+1)
                        .reduce((acumula,cambia) -> sumar.apply(acumula,b))
                        .getAsInt();
        //Creamos la funcion de division
        BiFunction<Integer, Integer, Integer> dividir = (a,b) ->
                IntStream.range(0,a+1)
                        .reduce((acumula,cambia) ->
                        {
                            acumula = multiplicar.apply(cambia,b) ==a ? cambia:acumula;
                            return acumula;
                        }).getAsInt();

        System.out.println(sumar.apply(2,3));
        System.out.println(restar.apply(5,3));
        System.out.println(multiplicar.apply(4,5));
        System.out.println(dividir.apply(27,3));
    }
}
