<html>
<head>
    <title>
        index.jsp
    </title>
</head>
<body>
   <div>
       Calculator
   </div>
   <form action="/calculator" method="get">
   <div>
       <input type="number" step="any" placeholder="First number" name="firstNum">
       <input type="number" step="any" placeholder="Second Number" name="secondNum">
   </div>
    <div>
        <button type="submit" name="operation" value='+'>+</button>
        <button type="submit" name="operation" value='-'>-</button>
        <button type="submit" name="operation" value='/'>/</button>
        <button type="submit" name="operation" value='*'>*</button>
    </div>
   </form>
</body>
</html>