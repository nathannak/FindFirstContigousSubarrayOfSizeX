public class Main {

    public static void main(String[] args)
    {

        //main logic to solve: https://tinyurl.com/y3tacon3

//        int[] arr =  new int[]{0,0,1,0,0,1,1,1,0,0,2,0,0,0};
        int[] arr =  new int[]{0,0,1,0,0,0,1,1,0,0,2,0,1,0};
//        int[] arr =  new int[]{0,0,1,0,0,1,1,1,0,0,2,0,1,0};

        int len = 3 ; // looking for contiguous array of size 3 made of 0's
        System.out.println( finFirstC(0,arr.length-1,len,arr)[0]+ " && " + finFirstC(0,arr.length-1,len,arr)[1]);

    }

    public static int[] finFirstC (int start, int finish, int len, int [] arr) {

        //terminating condition
        if( start + (len-1) > finish ) return new int[] {-1,-1};

        int count=0;

        int i =0;
        for(i = start ; i <= finish ; i++) {

            if(arr[i]==0) count++;
            else break;
        }

        //note i-1 is where it finishes
        if(count==len) return new int[]{start,i-1};

        //only move start forward, because we want the first contiguous array from left
        start++;


        //purge useless numbers from start and finish
        while(arr[start]!=0  &&  start<arr.length  )    start++;
        while(arr[finish]!=0 &&  finish>=0         )    finish--;

        return finFirstC(start,finish,len,arr);

    }

}

