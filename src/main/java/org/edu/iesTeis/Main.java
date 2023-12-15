package org.edu.iesTeis;

public class Main {
    public static int chance (int... diceValues) {
        int total = 0;
        for (int value : diceValues) {
            total += value;
        }
        return total;
    }

    public static int yatzy(int... dice)
    {
        int[] counts = new int[6];
        for (int die : dice)
            counts[die-1]++;
        for (int i = 0; i != 6; i++)
            if (counts[i] == 5)
                return 50;
        return 0;
    }

    public static int ones(int... dice) {
        int contador = 0;

        for (int dado : dice) {
            if (dado == 1) {
                contador++;
            }
        }

        return contador;
    }

    public static int twos(int... dados) {
        int suma = 0;
        int valorBuscado = 2;

        for (int dado : dados) {
            if (dado == valorBuscado) {
                suma += valorBuscado;
            }
        }

        return suma;
    }

    public static int threes(int... dados) {
        int suma = 0;
        int valorBuscado = 3;

        for (int dado : dados) {
            if (dado == valorBuscado) {
                suma += valorBuscado;
            }
        }

        return suma;
    }

    protected int[] dice;
    public Main(int... diceValues) {
        dice = new int[5];
        for (int i = 0; i < 5; i++) {
            dice[i] = diceValues[i];
        }
    }

    public int fours()
    {
        int suma = 0;

        for (int valorDado : dice) {
            if (valorDado == 4) {
                suma += 4;
            }
        }

        return suma;
    }

    public int fives()
    {
        int s = 0;
        int i;
        for (i = 0; i < dice.length; i++)
            if (dice[i] == 5)
                    s = s + 5;
        return s;
    }

    public int sixes()
    {
        int suma = 0;

        for (int valorDado : dice) {
            if (valorDado == 6) {
                suma += 6;
            }
        }

        return suma;
    }

    public static int scorePair(int... dados) {
        int[] counts = new int[6];

        for (int dado : dados) {
            counts[dado - 1]++;
        }

        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                return (i + 1) * 2;
            }
        }

        return 0;
    }

    public static int twoPair(int... dados) {
        int[] counts = new int[6];

        for (int dado : dados) {
            counts[dado - 1]++;
        }

        int n = 0;
        int score = 0;

        for (int i = 5; i >= 0; i--) {
            if (counts[i] >= 2) {
                n++;
                score += (i + 1);
            }
        }

        return (n == 2) ? score * 2 : 0;
    }

    public static int fourOfAKind(int... dados) {
        int[] tallies = new int[6];

        for (int dado : dados) {
            tallies[dado - 1]++;
        }

        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 4) {
                return (i + 1) * 4;
            }
        }

        return 0;
    }

    public static int threeOfAKind(int... dados) {
        int[] tallies = new int[6];

        for (int dado : dados) {
            tallies[dado - 1]++;
        }

        for (int i = 0; i < 6; i++) {
            if (tallies[i] >= 3) {
                return (i + 1) * 3;
            }
        }

        return 0;
    }

    public static int smallStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[0] == 1 &&
                tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1)
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}

