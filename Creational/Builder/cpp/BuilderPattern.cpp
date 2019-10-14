#include <iostream>
#include <memory>

class Sandwich {
public:
    void setBread(const std::string& bread){
        m_bread = bread;
    }

    void setMeat(const std::string& meat){
        m_meat = meat;
    }

    void setCheese(const std::string& cheese){
        m_cheese = cheese;
    }

    void setSauce(const std::string& sauce){
        m_sauce = sauce;
    }
    
    void toast() const {
        std::cout<<"The sandwich contains "<<
        m_bread<<" bread, "<<
        m_meat<<" sauce, "<<
        m_cheese<<" cheese, "<<
        m_sauce<<" sauce."<<
        std::endl;
    }
private:
    std::string m_bread;
    std::string m_meat;
    std::string m_cheese;
    std::string m_sauce;
};

class SandwichBuilder {
public:
    virtual ~SandwichBuilder() = default;
    void createNewSandwich(){
        m_sandwich = std::make_unique<Sandwich>();
    }
    Sandwich* getSandwich() {
        return m_sandwich.release();
    }
    virtual void buildBread() = 0;
    virtual void buildMeat() = 0;
    virtual void buildCheese() = 0;
    virtual void buildSauce() = 0;
    
protected:
    std::unique_ptr<Sandwich> m_sandwich;
};

class ItalianBMTBuilder:public SandwichBuilder {
public:
    ~ItalianBMTBuilder() override = default;
    void buildBread() override {
        m_sandwich->setBread("Oregano bread");
    }
    void buildMeat() override {
        m_sandwich->setMeat("Pepperoni meat");
    }
    void buildCheese() override {
        m_sandwich->setCheese("Emmental cheese");
    }
    void buildSauce() override {
        m_sandwich->setSauce("Sweet onion sauce");
    }
};

class TunaBuilder:public SandwichBuilder {
public:
    ~TunaBuilder() override = default;
    void buildBread() override {
        m_sandwich->setBread("Whole grain bread");
    }
    void buildMeat() override {
        m_sandwich->setMeat("Tuna meat");
    }
    void buildCheese() override {
        m_sandwich->setCheese("Cheddar cheese");
    }
    void buildSauce() override {
        m_sandwich->setSauce("Mayonaise sauce");
    }
};

class Cook{
public:
    void toastSandwich() const {
        m_sandwichBuilder->getSandwich()->toast();
    }
    void createSandwich(SandwichBuilder* sandwichBuilder){
        m_sandwichBuilder = sandwichBuilder;
        m_sandwichBuilder->createNewSandwich();
        m_sandwichBuilder->buildBread();
        m_sandwichBuilder->buildMeat();
        m_sandwichBuilder->buildCheese();
        m_sandwichBuilder->buildSauce();
    }
private:
    SandwichBuilder* m_sandwichBuilder;
};

int main(){
    Cook cook{};
    ItalianBMTBuilder italianBMTBuilder;
    cook.createSandwich(&italianBMTBuilder);
    cook.toastSandwich();

    TunaBuilder tunaBuilder;
    cook.createSandwich(&tunaBuilder);
    cook.toastSandwich();
}