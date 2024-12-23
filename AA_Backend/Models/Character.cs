using AA_Backend.Models.Enums;

namespace AA_Backend.Models
{
    public class Character
    {
        public int Id { get; set; }
        public string FirstName { get; set; } = null!;
        public string LastName { get; set; } = null!;
        public Class Class { get; set; }
    }
}
