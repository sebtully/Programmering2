package train;

import java.util.NoSuchElementException;

public class LinkedListTrain
{
    public WagonNode firstWagon;

    /**
     * Constructs an empty linked list train.
     */
    public LinkedListTrain()
    {
        this.firstWagon = null;
    }

    /**
     * Returns the first wagon node in the linked list train.
     * 
     * @return the first wagon node
     * 
     * @throws NoSuchElementException if the train has no wagon nodes
     */
    public WagonNode getFirst()
    {
        if (this.firstWagon == null)
        {
            throw new NoSuchElementException();
        }
        return this.firstWagon;
    }

    /**
     * Adds a wagon node to the front of the linked list train.
     * 
     * @param wagon the wagon node to add
     */
    public void addFirst(WagonNode wagon)
    {
        // Assignment 1: Implement this add method...
        if (this.firstWagon != null){
            wagon.setNextWagon(this.firstWagon);
        }
        this.firstWagon = wagon;
    }

    /**
     * Removes the first wagon node in the linked list train.
     * 
     * @return the removed wagon node
     * 
     * @throws NoSuchElementException if the train has no wagon nodes
     */
    public WagonNode removeFirst()
    {
        // Assignment 2: Implement this remove method...
       if(this.firstWagon == null) {
           throw new NoSuchElementException();

       }
       WagonNode wagon = this.firstWagon;
       this.firstWagon = this.firstWagon.getNextWagon();
       return wagon;
    }

    /**
     * Counts the total number of wagon nodes in the linked list train.
     * 
     * @return the number of wagon nodes
     */
    public int count()
    {
        // Assignment 3: Implement this count method...
        int count = 0;
        WagonNode current = this.firstWagon;
        while (current != null){
            count++;
            current = current.getNextWagon();
        }
        return count;

    }

    /**
     * Removes the first wagon node in the linked list train.
     * 
     * @param wagon the wagon node to remove
     * @return <code>true</code> if the wagon node was found and removed;
     *         <code>false</code> otherwise
     */
    public boolean remove(WagonNode wagon)
    {
        // Assignment 4: Implement this remove method...
        WagonNode current = this.firstWagon;
        WagonNode previous = null;
        while (current != null){
            if (current == wagon){
                if (previous == null){
                    this.firstWagon = current.getNextWagon();
                } else {
                    previous.setNextWagon(current.getNextWagon());
                }
                return true;
            }
            previous = current;
            current = current.getNextWagon();
        }
        return false;
    }

    /**
     * Inserts a wagon node at a given position in the linked list train.
     * 
     * @param wagon    the wagon node to add
     * @param position the position where to add the wagon node
     */
    public void insertAt(WagonNode wagon, int position) {
        // Assignment 5: Implement this insert method...
       WagonNode current = this.firstWagon;
       WagonNode previous = null;
         int count = 0;
         while (current != null){
             if (count == position){
                 if (previous == null){
                     this.firstWagon = wagon;
                 } else {
                     previous.setNextWagon(wagon);
                 }
                 wagon.setNextWagon(current);
                 return;
             }
             previous = current;
             current = current.getNextWagon();
             count++;
         }
    }
}
