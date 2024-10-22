package org.example;

import java.util.*;

public class TestArrayListNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++)
        {
            list.add(rand.nextInt(10,21));
        }
        System.out.println("Lista Original: " + list);

        Set<Integer> singleElements = new HashSet<>();
        Map<Integer, Integer> repeatedItems = new HashMap<>();

        for (Integer element : list) {
            if (!singleElements.add(element)) {
                repeatedItems.put(element, repeatedItems.getOrDefault(element, 1) + 1);
            }
        }
        System.out.println("Itens Repetidos: " + repeatedItems);

        ArrayList<Integer> copiedList = (ArrayList<Integer>) list.clone();
        System.out.println("Lista Clonada: " + copiedList);
        copiedList.sort(Comparator.reverseOrder());
        System.out.println("Lista Clonada Ordenada por Ordem Descrescente: " + copiedList);
        list.remove(Collections.max(list));
        System.out.println("Lista Original Sem o Maior Item: " + list);
        copiedList.remove(Collections.min(copiedList));
        System.out.println("Lista Clonada sem o Menor Item: " + copiedList);

        list.addAll(copiedList);
        System.out.println("Lista Original + Lista Clonada: " + list);
        System.out.println("Tamanho da Lista Original: " + list.size());

        System.out.println("Soma dos Elementos da Lista Original: " + list.stream().mapToInt(Integer::intValue).sum());

        list.set(list.indexOf(Collections.min(list)),
                (int) list.stream()
                        .mapToInt(Integer::intValue)
                        .average().orElse(0.0));
        System.out.println("Lista Original Após a Substituição do Menor Item: " + list);
        Integer[] array = new Integer[]{2, 4, 7, 9, 0};
        System.out.println("Array: " + Arrays.stream(array).toList());

        List<Integer> arrayToList = Arrays.stream(array).toList();
        System.out.println("Array como Lista: " + arrayToList);
    }
}