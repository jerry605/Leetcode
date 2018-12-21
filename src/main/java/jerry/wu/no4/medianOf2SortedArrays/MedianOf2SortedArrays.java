package jerry.wu.no4.medianOf2SortedArrays;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOf2SortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int alen = nums1.length;
        int blen = nums2.length;
        int total = alen + blen;
        if((total&0x01)==1){
            return findKth(nums1,0,alen-1,nums2,0,blen-1,total/2+1);
        }else{
            return (findKth(nums1,0,alen-1,nums2,0,blen-1,total/2)+findKth(nums1,0,alen-1,nums2,0,blen-1,total/2+1))/2;
        }
    }

    public  double findKth(int A[],int fs,int fd,int B[],int ss,int sd,int k){
        int alen = fd-fs+1;
        int blen=sd-ss+1;
        if(alen>blen)
            return findKth(B,ss,sd,A,fs,fd,k);
        if(fd<fs)
            return B[ss+k-1];
        if(k==1)
            return Math.min(A[fs], B[ss]);
        int pa = Math.min(k/2, fd-fs+1);
        int pb=k-pa;
        if(A[fs+pa-1]<B[ss+pb-1]){
            return findKth(A,fs+pa,fd,B,ss,sd,k-pa);
        }
        else if(A[fs+pa-1]>B[ss+pb-1]){
            return findKth(A,fs,fd,B,ss+pb,sd,k-pb);
        }else
            return A[fs+pa-1];
    }
}
