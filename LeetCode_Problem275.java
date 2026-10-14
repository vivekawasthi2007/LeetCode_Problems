
class LP275 {
    static int hIndex(int[] citations) {
        int left = 0;
        int right = citations.length - 1;
        int n = citations.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int papers = n - mid;

            if (citations[mid] >= papers) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return n - left;
    }

    public static void main(String args[]){
        int[] citations = {0,1,3,5,6};
        System.out.println(hIndex(citations));
    }
}

