/**
 * Created by Hakim on 9/29/15.
 */

/**
 * Sort big file.
 */
public class Solution06 {
    public static void main(String[] args){

        String solution = "We will use an external sorting procedure, namely an external merge sort" +
                "Assume we have x MB of memory available.\n" +
                "We divide the file in disk into chunks of size 20GB/xMB\n" +
                "We load each chunk separately in memory and sort it using " +
                "a standard sorting algorithm, like quick sort (or an algorithm which does not require extra space)\n" +
                "Each sorted chunk is saved back to disk\n" +
                "once all the chunks have been processed, we will merge them.\n" +
                "To do so, we divide each chunk into subchunks of size xMB/(number of chunks + 1)." +
                " We load each subchunk into memory, and allocate a buffer of size xMB/(number of chunks + 1) as well" +
                "We perform an n-way merge on these chunks (n = number of subchunks loaded) and save" +
                " the result in the buffer space allocated. Every time this buffer is full, we empty it to " +
                "disk (with the final result). Every time a subchunk loaded into memory is empty, we fill it with" +
                " the next part from it chunk in disk.\n" +
                "For example, if we assume that we use 1 GB of RAM, we will divide the original file into" +
                " 20 chunks of 1 GB each. Each of these chunks will be sorted in memory. When performing merge sort," +
                " we will load 1GB/21 of each chunk at a time.\n" +
                "\nThis merge phase of this procedure as described would not be efficient if the " +
                "memory available is small. Assume, for example, that we have 0.1GB available instead of 1GB. In that " +
                "case, 20GB/0.1 = 200 chunks. The size allocated for each of these chunks in memory when merging them " +
                "would be 0.1GB/200 = 512KB. The cost of IO operations to refill the chunks and empty the buffer would " +
                "slow down the soring process considerably. In this situation, we can choose to perform more merge sweeps." +
                " For instance, we could first merge 20 chunks at a time. Each would be ~5MB. This would result in " +
                "10 chunks that we could merge in a second pass.";

        System.out.println(solution);
    }
}
