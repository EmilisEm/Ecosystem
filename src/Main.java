import assets.animals.Evolvable;
import assets.animals.Wolf;
import assets.animals.Animal;


public class Main {
    public static void main(String[] args)
    {

        Evolvable wolf = new Wolf();
        Animal wolf2 = new Wolf();

        wolf.reproduce(wolf2);

    }
}
