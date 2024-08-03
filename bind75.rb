def merge_alternately(word1, word2)
    res=""
    if word2.length > word1.length
        long = word2
    else
        long = word1
    end

    (0...long.length).each do |i|
        if word1[i]!=nil
            res+=word1[i]
        end
        
        if word2[i]!=nil
            res+=word2[i]
        end
    end
    return res
end

def can_place_flowers(flowerbed, n)
    return true if n==0
    i = 0 

    while (i<flowerbed.length)
        if flowerbed[i]==1
            i+=2
        elsif flowerbed[i]==0
            if flowerbed[i+1]==0 || i== flowerbed.length-1
                n-=1
                i+=2
            elsif flowerbed[i+1] == 1
                i+=3
            end
        end
        return true if n==0
    end
    return false
end

#in java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int k=0;
        int j=0;
        for(i=1;i<nums.length;i++){
            if(nums[k]!=nums[i]){
                k++;
                nums[k]=nums[i];
            }
        }
        return k+1;
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==2){
            return nums.length;
        }
        int k=2;
        int i=2;
        for(i=2;i<nums.length;i++){
            if(nums[i]!=nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}

#gourp anagram with ruby

def group_anagrams(strs)
    hash =  Hash.new { |hash, key| hash[key] = [] }

    strs.each do |word|
        hash[word.split("").sort.join("")]<<word
    end

    return hash.values
end