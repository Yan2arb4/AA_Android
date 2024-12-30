using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;

namespace AA_Backend.Models
{
    public class User : IdentityUser
    {
        public int Id { get; set; }
        [Required]
        public string Name { get; set; } = null!;
        public List<Character> Characters { get; set; } = null!;
    }
}
