class Solution {
    public int numUniqueEmails(String[] emails) {
        
        HashSet<String> emailSet = new HashSet<>();
        
        for (int i = 0; i < emails.length; i++) {
        
            String orig = emails[i];
            String email = "";
            
            int plus = orig.indexOf("+"); 
            int at = orig.indexOf("@");
            
            if (plus != -1)
                email += orig.substring(0, plus);
            else
                email += orig.substring(0,at);
            
            email = email.replaceAll("\\.","");            
            email += orig.substring(at, orig.length());
            
            emailSet.add(email);
            
        }
        
        return emailSet.size();
        
    }
}