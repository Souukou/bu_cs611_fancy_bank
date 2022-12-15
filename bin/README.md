# CS611 OOD Final Project

## How to contribute to this repo

1. Create a new branch for each feature you want to add.

    ```
    git checkout -b stock_market
    git push -u origin stock_market
    ```

2. Push any number of commits you want into your branch. Remember to write unit tests for every method you provide. Run unit tests using `mvn test`. You can find an example unit test in src/test/java/fancybank
    ```
    git add .
    git commit -m "Add a fancy stock market"
    git push
    ```

3. Create a pull request in https://github.com/Souukou/bu_cs611_fancy_bank/pulls. An example pull request like this. https://github.com/Souukou/bu_cs611_fancy_bank/pull/1. Make sure everything looks good and all the features you provide are well-tested. If your files have conflicts with main branch, fix them before merge. Usually, your IDE can provide a nice interface for you to merge conflicts.
    ```
    git fetch
    git merge origin/main
    git push
    ```
    You will see a green badge near your commit ID that shows that your code passed the builder check.

4. When you are ready to merge, click **Squash and merge**. (**NOT Merge Pull Request**) This will combine all your commits into one single commit and merge it into main branch.

## Auto Format

To avoid different formatting rules by different IDE, we provided an xml format specification `java-formatter.xml` that could be imported to your own IDE.

* If you use the latest version of IDEA, you do not need to do anything. This format file is exported from IDEA.

* If you use VSCode, ctrl+shift+P, `Java Formatter Settings with Preview`, replace the `.vscode\java-formatter.xml` with our xml file.

* If you use Eclipse, Google it.