package lecture05BListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemons = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int sum = 0;

        while (!pokemons.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());
            int firstPokemon = pokemons.get(0);
            int lastPokemon = pokemons.get(pokemons.size() - 1);

            if (index < 0) {
                pokemons.set(0, lastPokemon);
                sum += firstPokemon;

                for (int i = 0; i < pokemons.size(); i++) {
                    int newValue;
                    if (pokemons.get(i) <= firstPokemon) {
                        newValue = pokemons.get(i) + firstPokemon;
                    } else {
                        newValue = pokemons.get(i) - firstPokemon;
                    }
                    pokemons.set(i, newValue);
                }
            } else if (index >= pokemons.size()) {
                pokemons.set(pokemons.size() - 1, firstPokemon);
                sum += lastPokemon;

                for (int i = 0; i < pokemons.size(); i++) {
                    int newValue;
                    if (pokemons.get(i) <= lastPokemon) {
                        newValue = pokemons.get(i) + lastPokemon;
                    } else {
                        newValue = pokemons.get(i) - lastPokemon;
                    }
                    pokemons.set(i, newValue);
                }
            } else {
                int pokemon = pokemons.get(index);
                pokemons.remove(index);
                sum += pokemon;

                for (int i = 0; i < pokemons.size(); i++) {
                    int newValue;
                    if (pokemons.get(i) <= pokemon) {
                        newValue = pokemons.get(i) + pokemon;
                    } else {
                        newValue = pokemons.get(i) - pokemon;
                    }
                    pokemons.set(i, newValue);
                }
            }
        }

        System.out.println(sum);
    }
}
