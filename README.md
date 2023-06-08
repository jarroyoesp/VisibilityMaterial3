# VisibilityMaterial3

Sample project to show how 'Visibility.Gone' looks like in a ConstraintLayout:

```
Checkbox(
    checked = false,
    onCheckedChange = { },
    modifier = Modifier
        .constrainAs(selectorRef) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            bottom.linkTo(parent.bottom)
            visibility = Visibility.Gone
        }
)
```


<img src="https://github.com/jarroyoesp/VisibilityMaterial3/blob/master/images/material3.png">

# Updated June 8th 2023

After update dependencies(`androidx.constraintlayout:constraintlayout-compose:1.1.0-alpha09`), the issue is fixed. 
More info here: https://issuetracker.google.com/issues/251721175