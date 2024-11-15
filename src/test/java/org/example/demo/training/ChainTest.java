package org.example.demo.training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChainTest {

    @Nested
    class EmptyCollection {

        private final Chain<String> chain = new Chain<>();

        @Test
        public void collectionIsEmpty() {
            assertTrue(chain.isEmpty());
        }

        @Test
        public void collectionSizeIsZero() {
            assertEquals(0, chain.size());
        }

        @Test
        public void getElementOutOfBounds() {
            assertThrows(IndexOutOfBoundsException.class, () -> chain.get(-1));
        }

        @Test
        public void getElement() {
            assertThrows(IndexOutOfBoundsException.class, () -> chain.get(0));
        }

        @Test
        public void removeElementOutOfBounds() {
            assertThrows(IndexOutOfBoundsException.class, () -> chain.remove(-1));
        }

        @Test
        public void removeElement() {
            assertThrows(IndexOutOfBoundsException.class, () -> chain.remove(0));
        }

    }

    @Nested
    class AddElementToEmptyCollection {

        private final Chain<String> chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT);

        @Test
        public void collectionIsNotEmpty() {
            assertFalse(chain.isEmpty());
        }

        @Test
        public void sizeIsNotZero() {
            final int expectedSize = 2;
            assertEquals(expectedSize, chain.size());
        }

        @Test
        public void checkContainsOrder() {
            assertTrue(isExactlyContains(chain, FIRST_ELEMENT, SECOND_ELEMENT));
        }

        @Test
        public void getFirstElement() {
            String element = chain.get(0);
            assertEquals(FIRST_ELEMENT, element);
        }

        @Test
        public void getLastElement() {
            int last = chain.size() - 1;
            String element = chain.get(last);
            assertEquals(SECOND_ELEMENT, element);
        }

        @Test
        @DisplayName("index < 0")
        public void getElementOutOfBounds() {
            assertThrows(IndexOutOfBoundsException.class, () -> chain.get(-1));
        }

        @Test
        @DisplayName("index >= size")
        public void getElementOutOfBounds2() {
            final int outOfBoundIndex = chain.size();
            assertThrows(IndexOutOfBoundsException.class, () -> chain.get(outOfBoundIndex));
        }

    }

    @Nested
    class RemoveFromIsNotEmptyCollection {

        @Nested
        class RemoveFistElement {
            private final Chain<String> chain;

            {
                chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT);
                chain.remove(0);
            }

            @Test
            public void collectionIsNotEmpty() {
                assertFalse(chain.isEmpty());
            }

            @Test
            public void sizeIsNotZero() {
                assertEquals(4, chain.size());
            }

            @Test
            public void checkContainsOrderAfterRemove() {
                assertTrue(isExactlyContains(chain, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT));
            }
        }

        @Nested
        class RemoveSecondElement {

            private final Chain<String> chain;

            {
                chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT);
                chain.remove(1);
            }

            @Test
            public void collectionIsEmpty() {
                assertFalse(chain.isEmpty());
            }

            @Test
            public void sizeIsNotZero() {
                final int expectedSize = 4;
                assertEquals(expectedSize, chain.size());
            }

            @Test
            public void checkContainsOrderAfterRemove() {
                assertTrue(isExactlyContains(chain, FIRST_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT));
            }
        }

        @Nested
        class RemoveThirdElement {
            private final Chain<String> chain;

            {
                chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT);
                chain.remove(2);
            }

            @Test
            public void collectionIsEmpty() {
                assertFalse(chain.isEmpty());
            }

            @Test
            public void sizeIsNotZero() {
                final int expectedSize = 4;
                assertEquals(expectedSize, chain.size());
            }

            @Test
            public void checkContainsOrderAfterRemove() {
                assertTrue(isExactlyContains(chain, FIRST_ELEMENT, SECOND_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT));
            }
        }

        @Nested
        class RemoveFourthElement {
            private final Chain<String> chain;

            {
                chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT);
                chain.remove(3);
            }

            @Test
            public void collectionIsNotEmpty() {
                assertFalse(chain.isEmpty());
            }

            @Test
            public void sizeIsNotZero() {
                final int expectedSize = 4;
                assertEquals(expectedSize, chain.size());
            }

            @Test
            public void checkContainsOrderAfterRemove() {
                assertTrue(isExactlyContains(chain, FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FIFTH_ELEMENT));
            }
        }

        @Nested
        class RemoveFifthElement {
            private final Chain<String> chain;

            {
                chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT, FIFTH_ELEMENT);
                chain.remove(4);
            }

            @Test
            public void collectionIsNotEmpty() {
                assertFalse(chain.isEmpty());
            }

            @Test
            public void sizeIsNotZero() {
                final int expectedSize = 4;
                assertEquals(expectedSize, chain.size());
            }

            @Test
            public void checkContainsOrderAfterRemove() {
                assertTrue(isExactlyContains(chain, FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT, FOURTH_ELEMENT));
            }
        }

        @Nested
        class RemoveAllElement {
            private final Chain<String> chain;

            {
                chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT);
                chain.remove(0);
                chain.remove(0);
                chain.remove(0);
            }

            @Test
            public void collectionIsEmpty() {
                assertTrue(chain.isEmpty());
            }

            @Test
            public void sizeIsZero() {
                assertEquals(0, chain.size());
            }
        }

        @Nested
        class RemoveElementOutOfBounds {
            private final Chain<String> chain = createChain(FIRST_ELEMENT, SECOND_ELEMENT, THIRD_ELEMENT);

            @Test
            @DisplayName("remove by index < 0")
            public void removeBeyondIndex() {
                assertThrows(IndexOutOfBoundsException.class, () -> chain.remove(-1));
            }

            @Test
            @DisplayName("remove by index >= size")
            public void removeBeyondIndex2() {
                final int outOfBoundIndex = chain.size();
                assertThrows(IndexOutOfBoundsException.class, () -> chain.remove(outOfBoundIndex));
            }
        }
    }

    @SafeVarargs
    private <T> boolean isExactlyContains(Chain<T> chain, T... items) {
        if (chain.size() != items.length) {
            return false;
        }
        for (int i = 0; i < items.length; i++) {
            T actual = chain.get(i);
            T expected = items[i];
            if (!expected.equals(actual)) {
                return false;
            }
        }
        return true;
    }

    private <T> int lastElementIndex(Chain<T> chain) {
        return chain.size() - 1;
    }

    private Chain<String> createChain(String... items) {
        final Chain<String> chain = new Chain<>();
        for (String item : items) {
            chain.add(item);
        }
        return chain;
    }

    private final static String FIRST_ELEMENT = "first";
    private final static String SECOND_ELEMENT = "second";
    private final static String THIRD_ELEMENT = "third";
    private final static String FOURTH_ELEMENT = "fourth";
    private final static String FIFTH_ELEMENT = "fifth";

}
