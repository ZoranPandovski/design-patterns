#ifndef DLIST_H
#define DLIST_H

//A simple doubly-linked list class
class DList{
	struct Node{
		int data_;
		Node* next_;
		Node* prev_;
		Node(const int& data=int{},Node* nx=nullptr,Node* pr=nullptr){
			data_=data;
			next_=nx;
			prev_=pr;
		}

	};
	Node* front_;
	Node* back_;
	int size_;

public:
	class const_iterator{
		friend class DList;
		Node* curr_;
		const_iterator(Node* n){
			curr_=n;
		}
	public:
		const_iterator(){
			curr_=nullptr;
		}
		const_iterator operator++(){
			curr_=curr_->next_;
			return *this;
		}
		const_iterator operator++(int){
			const_iterator old=*this;
			curr_=curr_->next_;
			return old;
		}
		const_iterator operator--(){
			curr_=curr_->prev_;
			return *this;
		}
		const_iterator operator--(int){
			const_iterator old=*this;
			curr_=curr_->next_;
			return old;
		}
		bool operator==(const_iterator rhs){
			return curr_==rhs.curr_;
		}
		bool operator!=(const_iterator rhs){
			return curr_!=rhs.curr_;
		}
		const int& operator*()const{return curr_->data_;}
	};
	class iterator:public const_iterator{
		friend class DList;
		iterator(Node* n):const_iterator(n){}
	public:
		iterator():const_iterator(){this->curr_=nullptr;}
		iterator operator++(){
			this->curr_=this->curr_->next_;
			return *this;
		}
		iterator operator++(int){
			iterator old=*this;
			this->curr_=this->curr_->next_;
			return old;			
		}
		iterator operator--(){
			this->curr_=this->curr_->prev_;
			return *this;
		}
		iterator operator--(int){
			iterator old=*this;
			this->curr_=this->curr_->prev_;
			return old;

		}
		int& operator*(){return this->curr_->data_;}
		const int& operator*() const{return this->curr_->data_;}
	};
	DList();
	~DList();
	iterator begin(){return iterator(front_->next_);}
	iterator end(){return iterator(back_);}
	const_iterator cbegin() const{return const_iterator(front_->next_);}
	const_iterator cend() const{return const_iterator(back_);}
	void push_front(const int& data);
	void push_back(const int& data);
	void pop_front();
	void pop_back();
	bool empty() const;
	int size() const;
};


DList::DList(){
	front_=new Node();
	back_= new Node();
	front_->next_=back_;
	back_->prev_=front_;
	size_=0;
}
DList::~DList(){
	Node* curr=front_;
	while(curr){
		Node* rm=curr;
		curr=curr->next_;
		delete rm;
	}
}


void DList::push_front(const int& data){
	Node* nn=new Node(data,front_->next_,front_);
	front_->next_->prev_=nn;
	front_->next_=nn;
	size_++;
}
void DList::push_back(const int& data){
	Node* nn=new Node(data,back_,back_->prev_);
	back_->prev_->next_=nn;
	back_->prev_=nn;
	size_++;
}
void DList::pop_front(){
	if(begin()!=end()){
		Node* rm = front_->next_;
		Node* second = rm->next_;
		second->prev_=front_;
		front_->next_=second;
		size_--;
		delete rm;
	}
}
void DList::pop_back(){
	if(begin()!=end()){
		Node* rm=back_->prev_;
		Node* secondLast=rm->prev_;
		secondLast->next_=back_;
		back_->prev_=secondLast;
		size_--;
		delete rm;
	}
}
bool DList::empty() const{
	return size_==0;
}
int DList::size() const{
	return size_;
}

#endif