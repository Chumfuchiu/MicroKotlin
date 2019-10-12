package com.chumfuchiu.happywave.kotlin.chapter05;

interface IA {
    default int x() {
        return 100;
    }
}

interface IB {
    default int x() {
        return -100;
    }
}

public class JavaConflicts {
    static class Test implements IA, IB {
        private int mx;

        public Test(int x) {
            mx = x;
        }

        @Override
        public int x() {
            if (mx < -100) {
                return ((IA) this).x();
            } else if (mx > 100) {
                return ((IB) this).x();
            } else {
                return mx;
            }
        }
    }

    public static void main(String[] args) {
        Test test1 = new Test(-200);
        Test test2 = new Test(0);
        Test test3 = new Test(200);
        System.out.println(test1.x());
        System.out.println(test2.x());
        System.out.println(test3.x());
    }
}
