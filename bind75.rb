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

def divide(dividend, divisor)
   # 0 <= r < b and a = b * q + r
   return 1 if dividend == divisor

   max_int = 2147483647
   is_positive = (dividend < 0 == divisor < 0)
   a = dividend.abs
   b = divisor.abs
   result = 0

   while(a >= b)
     q = 0

     while(a > (b << (q + 1)))
       q += 1
     end

     result += (1 << q)
     a = a - (b << q)
   end

   result = if (result > max_int && is_positive)
           max_int
         else
           result
         end

   is_positive ? result : -1 * result
end

def is_valid(s)
    brackets = []
    
    s.chars.each do |c|
        if c == '(' || c == '{' || c == '['
            brackets.push(c)
        else
            if brackets.empty?
                return false  # There's no matching open bracket.
            end
            
            open_bracket = brackets.pop
            
            if (c == ')' && open_bracket != '(') || (c == '}' && open_bracket != '{') || (c == ']' && open_bracket != '[')
                return false  # Mismatched closing bracket.
            end
        end
    end
    
    brackets.empty?  # All open brackets should be closed.
end

# sustring with no repeated chars using set

def length_of_longest_substring(s)
    return 0 if s.empty?
    return 0 if s.empty?

  char_set = Set.new
  left = 0
  max_length = 0

  s.each_char.with_index do |char, right|
    while char_set.include?(char)
      char_set.delete(s[left])
      left += 1
    end
    char_set.add(char)
    max_length = [max_length, char_set.length].max
  end

  max_length
end

# Integer to roman
def int_to_roman(num)
    alphas = %w[I IV V IX X XL L XC C CD D CM M]
    alpha_values = [1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000]
    ans = ""
    alphas.zip(alpha_values).reverse.each_with_index do |alpha_value, index|
      while num >= alpha_value[1]
        ans << alpha_value[0]
        num -= alpha_value[1]
      end
    end
    ans
end

#letter combination
def letter_combinations(digits)
    return [] if digits.empty?

    phone_map = ["abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"]
    output = []

    def backtrack(combination, next_digits, phone_map, output)
        if next_digits.empty?
            output << combination
        else
            letters = phone_map[next_digits[0].to_i - 2]
            letters.each_char do |letter|
                backtrack(combination + letter, next_digits[1..], phone_map, output)
            end
        end
    end

    backtrack("", digits, phone_map, output)
    output
end