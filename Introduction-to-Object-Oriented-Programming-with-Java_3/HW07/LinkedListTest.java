public class LinkedListTest {
    public static void main(String[] args) {
        // Test constructor and initial state
        System.out.println("Testing constructor and initial state:");
        LinkedList<String> list = new LinkedList<>();
        testCondition(list.size() == 0, "Initial size should be 0");
        testCondition(list.isEmpty(), "New list should be empty");

        // Test clear on empty list
        System.out.println("\nTesting clear on empty list:");
        list.clear();
        testCondition(list.size() == 0, "Size should still be 0 after clearing empty list");
        testCondition(list.isEmpty(), "List should still be empty after clearing empty list");

        // Create a different type of list to test generics
        System.out.println("\nTesting with Integer list:");
        LinkedList<Integer> intList = new LinkedList<>();
        testCondition(intList.size() == 0, "Integer list initial size should be 0");
        testCondition(intList.isEmpty(), "Integer list should be empty");
        
        // Test add methods
        System.out.println("\nTesting add methods:");
        list.add("first");
        testCondition(list.size() == 1, "Size should be 1 after adding first element");
        testCondition(!list.isEmpty(), "List should not be empty after adding element");
        
        list.add(0, "start");
        testCondition(list.size() == 2, "Size should be 2 after adding at beginning");
        
        list.add(1, "middle");
        testCondition(list.size() == 3, "Size should be 3 after adding in middle");
        
        // Test index validation
        System.out.println("\nTesting index validation:");
        try {
            list.add(-1, "invalid");
            System.out.println("FAIL: Should throw exception for negative index");
        } catch (IndexOutOfBoundsException e) {
            testCondition(e.getMessage().equals("Index out of bounds: -1"), 
                         "Correct exception message for negative index");
        }
        
        try {
            list.add(4, "invalid");
            System.out.println("FAIL: Should throw exception for index > size");
        } catch (IndexOutOfBoundsException e) {
            testCondition(e.getMessage().equals("Index out of bounds: 4"), 
                         "Correct exception message for too large index");
        }

        // Test get and set methods
        System.out.println("\nTesting get and set methods:");
        testCondition(list.get(0).equals("start"), "First element should be 'start'");
        testCondition(list.get(1).equals("middle"), "Second element should be 'middle'");
        testCondition(list.get(2).equals("first"), "Third element should be 'first'");

        // Test set method
        String oldValue = list.set(1, "updated");
        testCondition(oldValue.equals("middle"), "Old value should be 'middle'");
        testCondition(list.get(1).equals("updated"), "New value should be 'updated'");

        // Test get/set with invalid indices
        try {
            list.get(-1);
            System.out.println("FAIL: Should throw exception for negative index in get");
        } catch (IndexOutOfBoundsException e) {
            testCondition(e.getMessage().equals("Index out of bounds: -1"), 
                         "Correct exception message for negative index in get");
        }

        try {
            list.set(3, "invalid");
            System.out.println("FAIL: Should throw exception for index >= size in set");
        } catch (IndexOutOfBoundsException e) {
            testCondition(e.getMessage().equals("Index out of bounds: 3"), 
                         "Correct exception message for too large index in set");
        }

        // Test null values
        list.set(0, null);
        testCondition(list.get(0) == null, "Should allow null values");

        // Test contains and indexOf methods
        System.out.println("\nTesting contains and indexOf methods:");
        testCondition(list.contains("updated"), "Should contain 'updated'");
        testCondition(!list.contains("missing"), "Should not contain 'missing'");
        testCondition(list.contains(null), "Should contain null");
        
        testCondition(list.indexOf("updated") == 1, "Index of 'updated' should be 1");
        testCondition(list.indexOf("missing") == -1, "Index of 'missing' should be -1");
        testCondition(list.indexOf(null) == 0, "Index of null should be 0");
        
        // Test with duplicate values
        list.add("updated");
        testCondition(list.indexOf("updated") == 1, "indexOf should return first occurrence");
        
        // Test with different object types
        testCondition(!list.contains(Integer.valueOf(42)), "Should not contain Integer object");
        testCondition(list.indexOf(Integer.valueOf(42)) == -1, "Index of Integer object should be -1");

        // Test remove methods
        System.out.println("\nTesting remove methods:");
        
        // Test remove(int)
        String removedValue = list.remove(1);
        testCondition(removedValue.equals("updated"), "Removed value should be 'updated'");
        testCondition(list.size() == 3, "Size should decrease after remove");
        testCondition(list.indexOf("updated") == 2, "Last 'updated' should now be at index 2");
        
        // Test remove(Object)
        testCondition(list.remove("first"), "Should remove 'first'");
        testCondition(!list.contains("first"), "List should no longer contain 'first'");
        testCondition(list.size() == 2, "Size should decrease after remove");
        
        // Test removing null
        testCondition(list.remove(null), "Should remove null value");
        testCondition(!list.contains(null), "List should no longer contain null");
        testCondition(list.size() == 1, "Size should decrease after remove");
        
        // Test removing non-existent element
        testCondition(!list.remove("missing"), "Should return false when removing non-existent element");
        
        // Test index out of bounds
        try {
            list.remove(-1);
            System.out.println("FAIL: Should throw exception for negative index");
        } catch (IndexOutOfBoundsException e) {
            testCondition(e.getMessage().equals("Index out of bounds: -1"), 
                         "Correct exception message for negative index");
        }
        
        try {
            list.remove(list.size());
            System.out.println("FAIL: Should throw exception for index >= size");
        } catch (IndexOutOfBoundsException e) {
            testCondition(e.getMessage().equals("Index out of bounds: " + list.size()), 
                         "Correct exception message for too large index");
        }

        // Test toString method
        System.out.println("\nTesting toString method:");
        
        // Test empty list
        LinkedList<String> emptyList = new LinkedList<>();
        testCondition(emptyList.toString().equals("[]"), 
                     "Empty list should be represented as '[]'");
        
        // Test single element
        emptyList.add("one");
        testCondition(emptyList.toString().equals("[one]"), 
                     "Single element list should be represented as '[one]'");
        
        // Test multiple elements
        emptyList.add("two");
        emptyList.add("three");
        testCondition(emptyList.toString().equals("[one, two, three]"), 
                     "Multiple elements should be comma-space separated");
        
        // Test with null values
        LinkedList<String> nullList = new LinkedList<>();
        nullList.add(null);
        nullList.add("notNull");
        nullList.add(null);
        testCondition(nullList.toString().equals("[null, notNull, null]"), 
                     "Null values should be represented as 'null'");
                     
        // Test equals method
        System.out.println("\nTesting equals method:");
        
        // Test same object
        LinkedList<String> list1 = new LinkedList<>();
        testCondition(list1.equals(list1), "List should equal itself");
        
        // Test equal lists
        LinkedList<String> list2 = new LinkedList<>();
        testCondition(list1.equals(list2), "Empty lists should be equal");
        
        list1.add("one");
        list1.add("two");
        list2.add("one");
        list2.add("two");
        testCondition(list1.equals(list2), "Lists with same elements should be equal");
        
        // Test unequal lists
        LinkedList<String> list3 = new LinkedList<>();
        list3.add("one");
        list3.add("three");
        testCondition(!list1.equals(list3), "Lists with different elements should not be equal");
        
        // Test lists with null values
        LinkedList<String> list4 = new LinkedList<>();
        LinkedList<String> list5 = new LinkedList<>();
        list4.add(null);
        list4.add("one");
        list5.add(null);
        list5.add("one");
        testCondition(list4.equals(list5), "Lists with same null values should be equal");
        
        // Test against different object type
        testCondition(!list1.equals("not a list"), "List should not equal non-list object");
        
        // Test lists of different lengths
        list2.add("three");
        testCondition(!list1.equals(list2), "Lists of different lengths should not be equal");
    }

    private static void testCondition(boolean condition, String message) {
        System.out.println(message + ": " + (condition ? "PASS" : "FAIL"));
    }
}