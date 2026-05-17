int left = 0;
int result = 0;   // or Integer.MAX_VALUE based on problem

for (int right = 0; right < n; right++) {

    // 1. Expand window
    // include arr[right] or s.charAt(right)

    while (condition breaks) {
        // 2. Shrink window
        // remove arr[left] or s.charAt(left)
        left++;
    }

    // 3. Update answer
    result = Math.max(result, right - left + 1);
    // OR Math.min(...) depending on question
}

// use this when k size if not fixed 
// note: k element/char may fixed like (02.) and size not fixed then use this