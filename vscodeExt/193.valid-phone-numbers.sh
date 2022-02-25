#
# @lc app=leetcode id=193 lang=bash
#
# [193] Valid Phone Numbers
#

# @lc code=start
# Read from the file file.txt and output all valid phone numbers to stdout.
grep -P '^(\d{3}-|\(\d{3}\) )\d{3}-\d{4}$' file.txt
# grep -P '.*' file.txt

# @lc code=end

