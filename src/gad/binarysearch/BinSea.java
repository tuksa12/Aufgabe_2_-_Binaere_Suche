package gad.binarysearch;

import gad.binarysearch.Interval.NonEmptyInterval;

import java.util.Arrays;

public final class BinSea {

    private BinSea() {
    }

    public static int search(int[] sortedData, int value, Result result) {//A resposta é um index
        int index;
        int length = sortedData.length;
        int[] copy;
        int middleIndex = sortedData[length/2 - 1];
        int[] secondCopy = sortedData;

        while (true){
            if(middleIndex == value){
                index = length/2;
                return index;
            } else {
                if(middleIndex > value){
                copy = new int[length/2 - 1];
                for (int i = 0; i < copy.length; i++) {
                    copy[i] = sortedData[i];
                }
                sortedData = copy;
                middleIndex = sortedData[sortedData.length/2];

            } else if(middleIndex < value){
                copy = new int[length/2 ];
                for (int i = length/2 ; i < length; i++) {
                    copy[i - (length/2) ] = sortedData[i];
                }
                sortedData = copy;
                middleIndex = sortedData[sortedData.length/2 - 1];
            }
            length = sortedData.length;
            if(sortedData.length == 1){
                for (int i = 0; i < secondCopy.length; i++) {
                    if(sortedData[0] == secondCopy[i]){
                        return i;
                    }
                }
            }

        }
        }

    }

    public static int search(int[] sortedData, int value, boolean lowerBound, Result result) {
        int searchResult = search(sortedData, value, result);

        try{
            if(lowerBound){
                return searchResult-1;
            } else{
                return searchResult+1;


            }
        } catch (Exception e){
            return -1;
        }
    }

    public static Interval search(int[] sortedData, Interval valueRange, Result resultLower, Result resultHigher) {
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[] { 2, 7, 7, 42, 69, 1337, 2000, 9001 };

        System.out.println(search(array, 7, new StudentResult()));
        System.out.println(search(array, 100, new StudentResult()));

        System.out.println(search(array, 7, false, new StudentResult()));
        System.out.println(search(array, 100, true, new StudentResult()));

        System.out.println(search(array, new NonEmptyInterval(7, 1500), new StudentResult(), new StudentResult()));
        System.out.println(search(array, new NonEmptyInterval(9002, 10000), new StudentResult(), new StudentResult()));
    }
}
