
class BookList{
    constructor(bookRead, bookNotRead, list, array, lastReaded){
        this.bookRead = bookRead;//0
        this.bookNotRead = bookNotRead;//0
        this.numberOfBooks = list;//
        this.array = array;//[]
        this.lastReaded = lastReaded;
    }

    add(){
        let bookName = document.getElementById('bookName').value;
        let bookGenre = document.getElementById('bookGenre').value;
        let bookAuthor = document.getElementById('bookAuthor').value;
        this.array[this.numberOfBooks] = new Book(bookName,bookGenre,bookAuthor,false,null);
        this.numberOfBooks++;
        this.bookNotRead++;

        if(this.numberOfBooks==1){
            document.getElementById("currentBook").textContent = bookName;
        }
        if(this.numberOfBooks==2){
            document.getElementById("nextBook").textContent = bookName;
        }

        const item =`<div class='list__items' id='list_item${this.numberOfBooks}'>
            <span>${this.numberOfBooks}<input type="checkbox" id='item_${this.numberOfBooks}' onClick="booklist.finishCurrentBook(this.id, this.checked)"></span>
            <p id="item_text_${this.numberOfBooks}"> ${bookName} </p>
            <button class='item__btn'id="btn_${this.numberOfBooks}" onClick="booklist.deleteCurrentBook(this.id)">X</button>
            </div>`;
        document.querySelector('#list_item').insertAdjacentHTML('beforeend', item);

        document.getElementById("isReaded").textContent = booklist.bookRead;
        document.getElementById("isntReaded").textContent = booklist.bookNotRead;
        document.getElementById("numberOfBooks").textContent = booklist.numberOfBooks;
    }

    finishCurrentBook(id,checked){

        let index = id.split("_")[1];
        
        console.log(index);
        if(checked){
            this.array[index-1].isRead = true;
            this.bookRead++;
            this.bookNotRead--;
            this.array[index-1].readDate = Date(Date.now());
            document.getElementById("item_text_"+index).style.textDecoration = "line-through";
            this.lastReaded.push(this.array[index-1].Title);


        }else{
            this.array[index-1].isRead = false;
            this.bookRead--;
            this.bookNotRead++;
            this.array[index-1].readDate = null;
            document.getElementById("item_text_"+index).style.textDecoration = "none";
           
            for(let i = 0; i < this.lastReaded.length-1; i++){
                if(this.array[index-1].Title == this.lastReaded[i] && i != 0){
                    this.lastReaded[i] = null;
                    if( i == this.lastReaded.length-1 )this.lastReaded.pop;
                }
            }
        }

        document.getElementById("isReaded").textContent = booklist.bookRead;
        document.getElementById("isntReaded").textContent = booklist.bookNotRead;
        document.getElementById("numberOfBooks").textContent = booklist.numberOfBooks;
        document.getElementById("lastBook").textContent = this.lastReaded[this.lastReaded.length-1];
        
        let i=0;
        for( i ; i <this.numberOfBooks; i++){
            if (this.array[i].isRead == false){
                document.getElementById("currentBook").textContent = this.array[i].Title;
                break;
            }
        } 
        for( i++ ; i <this.numberOfBooks; i++){
            if (this.array[i].isRead == false){
                document.getElementById("nextBook").textContent = this.array[i].Title;
                break;
            }
        }
    }

    deleteCurrentBook(id, checked){
        
        let index = id.split("_")[1];
        console.log(index);
        if(this.array[index-1].isRead){
            this.array[index-1].isRead = false;
            this.bookRead--;
            this.numberOfBooks--;
            this.array[index-1].readDate = null;
        }else{
            this.array[index-1].isRead = false;
            this.bookNotRead--;
            this.numberOfBooks--;
            this.array[index-1].readDate = null;
        }
        let elem = document.getElementById('list_item' + index);
        elem.remove(elem);

        document.getElementById("isReaded").textContent = booklist.bookRead;
        document.getElementById("isntReaded").textContent = booklist.bookNotRead;
        document.getElementById("numberOfBooks").textContent = booklist.numberOfBooks;
      
        let i=0;
        for( i ; i <this.numberOfBooks; i++){
            if (this.array[i].isRead == false){
                document.getElementById("currentBook").textContent = this.array[i].Title;
                break;
            }
        } 
        for( i++ ; i <this.numberOfBooks; i++){
            if (this.array[i].isRead == false){
                document.getElementById("nextBook").textContent = this.array[i].Title;
                break;
            }
        }
    }
    
}

class Book{
    constructor(Title, Genre, Author, isRead, readDate){
        this.Title = Title;
        this.Genre = Genre;
        this.Author = Author;
        this.isRead = isRead;
        this.readDate = readDate;
    }

}

booklist = new BookList(0,0,0,[],[]);


module.exports = {
    Book, BookList
}